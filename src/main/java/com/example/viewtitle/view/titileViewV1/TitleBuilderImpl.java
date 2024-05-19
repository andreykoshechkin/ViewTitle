package com.example.viewtitle.view.titileViewV1;

import com.example.viewtitle.view.OrganizationData;
import lombok.*;

import java.math.BigDecimal;

import static com.example.viewtitle.view.titileViewV1.TitleBuilderImpl.MarkerColor.*;

public class TitleBuilderImpl implements TitleBuilder {
    private final static String KIB_POSTFIX = " КИБ";

    @Override
    public String titleBuilder() {
        return titleBuilder(null, false);
    }

    @Override
    public String titleBuilder(boolean bold) {
        return titleBuilder(null, bold);
    }

    @Override
    public String titleBuilder(MarkerColor markerColor) {
        return titleBuilder(markerColor, false);
    }

    @Override
    public String titleBuilder(MarkerColor markerColor, boolean bold) {
        StringBuilder builder = new StringBuilder();


        if (bold) {
            builder.append("<b>");
        }

        builder.append("<span style=\"color:");
        builder.append(markerColor == null ? MEDIUMSEAGREEN : markerColor.getColorName());
        builder.append(";\">");
        builder.append(KIB_POSTFIX);
        builder.append("</span>");

        if (bold) {
            builder.append("</b>");
        }

        return builder.toString();
    }
//
    public String commonServicesViewTitle(OrganizationData clientInfo, BigDecimal requestId, BigDecimal cusId) {
        String inn = "";
        String orgName = "";
        String titleContent = "";
        String requestIdStr = requestId != null ? requestId.toString() : "";
        String kib = isKib(clientInfo) ? titleBuilder(BLUE, true) : "";


        if (clientInfo != null) {
            orgName = clientInfo.getCusShortName() != null ? clientInfo.getCusShortName() : clientInfo.getName();
            inn = clientInfo.getINN();
        }


        if (!requestIdStr.isEmpty()) {
            titleContent = String.format("Заявка № %s (У). ИНН %s. %s %s", requestIdStr, inn, orgName, kib);
        } else {
            titleContent = String.format("ИНН %s. %s %s", inn, orgName, kib);
        }

        return "<div>" + titleContent + "</div>";
    }


    public String commonServicesViewTitle2(OrganizationData clientInfo, BigDecimal requestId, BigDecimal cusId) {


        String s;
        String inn = "";
        String orgName = "";

        if (clientInfo != null) {
            orgName = clientInfo.getCusShortName() != null ? clientInfo.getCusShortName() : clientInfo.getName();
            inn = clientInfo.getINN();
        }


        if (requestId != null) {
            s = "Заявка № %requestId% (У). ИНН %inn%.  %orgName%";
        } else {
            s = "ИНН %inn%. %orgName%";
        }

        String titleContent = s.replace("%requestId% ", requestId != null ? requestId.toString() : "")
                .replace("%orgName%", orgName == null || orgName.isEmpty() ? "" : orgName)
                .replace("%inn%", inn.isEmpty() ? "" : inn);

        return isKib(clientInfo)
                ? titleBuilder(BLUE, true)
                : titleContent;
    }

    private boolean isKib(OrganizationData organizationData) {
        return organizationData.getCategory().equals(BigDecimal.valueOf(151));
    }

    @Getter
    @AllArgsConstructor
    public enum MarkerColor {
        RED("red"),
        BLUE("blue"),
        GREEN("greenr"),
        MEDIUMSEAGREEN("mediumSeaGreen");
        private final String colorName;
    }
}
/*
public String commonServicesViewTitle2(OrganizationData clientInfo, BigDecimal requestId, BigDecimal cusId) {


    String s;
    String inn = "";
    String orgName = "";

    if (clientInfo != null) {
        orgName = clientInfo.getCusShortName() != null ? clientInfo.getCusShortName() : clientInfo.getName();
    } else {
        inn = clientInfo.getINN();
    }


    if (requestId != null) {
        s = "Заявка № %requestId% (У). ИНН %inn%.  %orgName%";
    } else {
        s = "ИНН %inn%. %orgName%";
    }

    String titleContent = s.replace("%requestId% ", requestId != null ? requestId.toString() : "")
            .replace("%orgName%", orgName == null || orgName.isEmpty() ? "" : orgName)
            .replace("%inn%", inn.isEmpty() ? "" : inn);

    return isKib(clientInfo)
            ? buildTitle(titleContent,  true)
            : titleContent;
}*/
