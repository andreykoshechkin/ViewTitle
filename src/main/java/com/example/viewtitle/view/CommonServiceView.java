package com.example.viewtitle.view;

import com.example.viewtitle.view.titileViewV1.TitleBuilderImpl;
import com.example.viewtitle.view.titileViewV2.TitleBuilderV2;
import com.example.viewtitle.view.titileViewV2.TitleBuilderV2Impl;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
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
    private Button button = new Button("CRM");

    public CommonServiceView() {



        OrganizationData organizationData = new OrganizationData();

        organizationData.setName("ООО Совкомбанк");
        organizationData.setINN("88899911133");
        organizationData.setCategory(BigDecimal.valueOf(151));
        organizationData.setGroup(BigDecimal.valueOf(51));



        titleV1 = new Html(titleBuilderV1.commonServicesViewTitle(organizationData, BigDecimal.valueOf(11), BigDecimal.valueOf(151)));
        titleV2 = new Html(titleBuilderV2.commonServicesViewTitle(organizationData, BigDecimal.valueOf(11), BigDecimal.valueOf(151)));

        button.addClickListener(event -> {
            getUI().ifPresent(ui -> ui.getPage().open("https://www.google.com", "_blank"));
        });
        add(titleV1, titleV2, button);

    }
}
/**
 *
 * _self: Открывает ресурс в том же фрейме или окне, в котором находится ссылка. Это значение по умолчанию.
 * _parent: Открывает ресурс в родительском фрейме, если таковой существует. В противном случае ведет себя как _self.
 * _top: Открывает ресурс в полном окне, отменяя все фреймы. Ведет себя как _self, если нет вложенных фреймов.
 *
 */

