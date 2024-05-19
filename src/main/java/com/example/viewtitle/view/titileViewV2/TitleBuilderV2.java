package com.example.viewtitle.view.titileViewV2;

import com.example.viewtitle.view.titileViewV2.TitleBuilderV2Impl.MarkerColor2;
import org.springframework.stereotype.Component;

@Component
public interface TitleBuilderV2 {

    String buildTitle(String titleContent, boolean bold);
    String buildTitle(String titleContent, MarkerColor2 markerColor2);
    String buildTitle(String titleContent, MarkerColor2 markerColor2, boolean bold);
    String buildTitle(String titleContent, MarkerColor2 contentColor, MarkerColor2 markerColor2, boolean bold);
    String buildTitle(String titleContent, MarkerColor2 contentColor, String marker, MarkerColor2 markerColor2, boolean bold);
}
