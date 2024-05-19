package com.example.viewtitle.view;

import com.example.viewtitle.view.titileViewV1.TitleBuilderImpl;
import com.example.viewtitle.view.titileViewV2.TitleBuilderV2;
import com.example.viewtitle.view.titileViewV2.TitleBuilderV2Impl;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


import java.math.BigDecimal;
@Route("serviceView")
public class CommonServiceView extends VerticalLayout {

    private TitleBuilderImpl titleBuilderV1 =  new TitleBuilderImpl();
    private TitleBuilderV2Impl titleBuilderV2 =  new TitleBuilderV2Impl();
    private Html titleV1;
    private Html titleV2;

    public CommonServiceView() {
        OrganizationData organizationData = new OrganizationData();

        organizationData.setName("ООО Совкомбанк");
        organizationData.setINN("88899911133");
        organizationData.setCategory(BigDecimal.valueOf(151));
        organizationData.setGroup(BigDecimal.valueOf(51));



        titleV1 = new Html(titleBuilderV1.commonServicesViewTitle2(organizationData, BigDecimal.valueOf(11), BigDecimal.valueOf(151)));
        titleV2 = new Html(titleBuilderV2.commonServicesViewTitle(organizationData, BigDecimal.valueOf(11), BigDecimal.valueOf(151)));

        add(titleV1, titleV2);

    }
}
