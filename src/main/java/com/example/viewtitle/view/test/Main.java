package com.example.viewtitle.view.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AccoutXGGList accoutXGGList = new AccoutXGGList();
        List<ClientXXG> xxgLsit =  new ArrayList<>();
        xxgLsit.add(new ClientXXG(BigDecimal.valueOf(3), BigDecimal.valueOf(1)));
        xxgLsit.add(new ClientXXG(BigDecimal.valueOf(922), BigDecimal.valueOf(5)));
        xxgLsit.add(new ClientXXG(BigDecimal.valueOf(922), BigDecimal.valueOf(6)));



        accoutXGGList.setClientXXGS(xxgLsit);
        ClientService clientService = new ClientService();


        List<AccoutXGGList> accoutXGGList1 = List.of(accoutXGGList);

        List<AccoutXGGList> accoutXGGLists = clientService.testExample3(accoutXGGList1);
        System.out.println(accoutXGGLists);


    }
}
