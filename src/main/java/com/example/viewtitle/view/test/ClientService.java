package com.example.viewtitle.view.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

    /**
     * Условие: Если у клиента есть категория 3 + группа 2 и нету категории 922/* кроме 922/5
     * '*' - означает любая группа
     *
     *
     */

    public List<AccoutXGGList> testExample(List<AccoutXGGList> accoutXGGLists){
        return accoutXGGLists.stream()
                .filter(it -> it.getClientXXGS().stream().anyMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(3)) && kg.getGroup().equals(BigDecimal.valueOf(2))))
                .filter(it -> it.getClientXXGS().stream().noneMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(922)) && !kg.getGroup().equals(BigDecimal.valueOf(5))))
                .collect(Collectors.toList());
    }


    public List<AccoutXGGList> testExample2(List<AccoutXGGList> accoutXGGLists){
        return accoutXGGLists.stream()
                .filter(it -> it.getClientXXGS().stream().anyMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(3)) && kg.getGroup().equals(BigDecimal.valueOf(2))))
                .filter(it -> it.getClientXXGS().stream().noneMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(922))))
                .collect(Collectors.toList());
    }

    public List<AccoutXGGList> testExample3(List<AccoutXGGList> accoutXGGLists) {
        return accoutXGGLists.stream()
                .filter(it -> it.getClientXXGS().stream()
                        .anyMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(3)) && kg.getGroup().equals(BigDecimal.valueOf(2))))
                .filter(it -> {
                    boolean has922_5 = it.getClientXXGS().stream()
                            .anyMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(922)) && kg.getGroup().equals(BigDecimal.valueOf(5)));
                    boolean hasOther922 = it.getClientXXGS().stream()
                            .anyMatch(kg -> kg.getCategory().equals(BigDecimal.valueOf(922)) && !kg.getGroup().equals(BigDecimal.valueOf(5)));
                    return !hasOther922 || has922_5;
                })
                .collect(Collectors.toList());
    }

}
