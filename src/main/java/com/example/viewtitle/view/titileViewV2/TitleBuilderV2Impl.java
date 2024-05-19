package com.example.viewtitle.view.titileViewV2;

import com.example.viewtitle.view.OrganizationData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.example.viewtitle.view.titileViewV2.TitleBuilderV2Impl.MarkerColor2.*;

@Component
public class TitleBuilderV2Impl implements TitleBuilderV2 {

    private final static String KIB_POSTFIX = " КИБ";

    @Override
    public String buildTitle(String titleContent, boolean bold) {
        return buildTitle(titleContent, null, null, null, bold);
    }

    @Override
    public String buildTitle(String titleContent, MarkerColor2 markerColor2) {
        return buildTitle(titleContent, null, null, markerColor2, false);
    }

    @Override
    public String buildTitle(String titleContent, MarkerColor2 markerColor2, boolean bold) {
        return buildTitle(titleContent, null, null, markerColor2, bold);
    }

    @Override
    public String buildTitle(String titleContent, MarkerColor2 contentColor, MarkerColor2 markerColor2, boolean bold) {
        return buildTitle(titleContent, contentColor, null, markerColor2, bold);
    }

    @Override
    public String buildTitle(String titleContent, MarkerColor2 contentColor, String marker, MarkerColor2 markerColor2, boolean bold) {
        StringBuilder builder = new StringBuilder();
        builder.append("<div>");

        appendSpan(builder, titleContent, contentColor, false);
        appendSpan(builder, KIB_POSTFIX, markerColor2, bold);

        builder.append("</div>");
        return builder.toString();
    }

    private void appendSpan(StringBuilder builder, String content, MarkerColor2 color, boolean bold) {
        builder.append("<span style=\"color:");
        builder.append(color == null ? MarkerColor2.RED.getColorName() : color.getColorName());
        builder.append(";\">");

        if (bold) {
            builder.append("<b>");
        }

        builder.append(content);

        if (bold) {
            builder.append("</b>");
        }

        builder.append("</span>");
    }
    public String commonServicesViewTitle(OrganizationData clientInfo, BigDecimal requestId, BigDecimal cusId) {
        String inn = "";
        String orgName = "";
        String titleContent = "";
        String requestIdStr = requestId != null ? requestId.toString() : "";


        if (clientInfo != null) {
            orgName = clientInfo.getCusShortName() != null ? clientInfo.getCusShortName() : clientInfo.getName();
            inn = clientInfo.getINN();
        }


        if (!requestIdStr.isEmpty()) {
            titleContent = String.format("Заявка № %s (У). ИНН %s. %s", requestIdStr, inn, orgName);
        } else {
            titleContent = String.format("ИНН %s. %s", inn, orgName);
        }

        return isKib(clientInfo) ? buildTitle(titleContent, GREEN, RED, true) : "";
    }

    private boolean isKib(OrganizationData organizationData) {
        return organizationData.getCategory().equals(BigDecimal.valueOf(151));
    }


    @Getter
    @AllArgsConstructor
    public enum MarkerColor2 {
        RED("red"),
        BLUE("blue"),
        GREEN("green"),
        MEDIUMSEAGREEN("MediumSeaGreen");
        private final String colorName;
    }
}
