package com.example.viewtitle.view.titileViewV1;

import org.springframework.stereotype.Component;

import static com.example.viewtitle.view.titileViewV1.TitleBuilderImpl.*;

@Component
public interface TitleBuilder {
    String titleBuilder();

    String titleBuilder(boolean bold);
    String titleBuilder(MarkerColor markerColor);

    String titleBuilder(MarkerColor markerColor, boolean bold);
}
