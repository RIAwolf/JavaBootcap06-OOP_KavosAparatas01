package com.company.controller.interfaces;

public interface IAparatas {
    void fillProducts(float water, float sugar, float beans);
    boolean isReady();
    void proccessChoice(String coffeType);
    void saveStatus();
    void showProducts();
    void showStatus();
    void washMaker();

    void selectDataSource();
}
