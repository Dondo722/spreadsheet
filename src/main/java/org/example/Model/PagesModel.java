package org.example.Model;

public class PagesModel {

    private static int currentPage = 1;
    private static int lastPage = 1;
    private static int rawsCount = -1;

    public static int getCurrentPage() {
        return currentPage;
    }

    public static int getLastPage() {
        return lastPage;
    }

    public static int getRawsCount() {
        return rawsCount;
    }

    public static void setCurrentPage(int currentPage) {
        PagesModel.currentPage = currentPage;
    }

    public static void countLastPage(int maxRaws){
        if(rawsCount == -1 )return;
        PagesModel.setLastPage((int)(Math.ceil( maxRaws/((double) PagesModel.getRawsCount()))));
    }

    public static void countCurrentPage(int num){
        for(int i = 0; i < lastPage; i ++){
            if (i * PagesModel.rawsCount <= num && (i+1) * PagesModel.rawsCount >= num)
                PagesModel.currentPage  = (i+1);
        }
    }

    public static void setLastPage(int lastPage) {
        PagesModel.lastPage = lastPage;
    }

    public static void setRawsCount(int rawsCount) {
        PagesModel.rawsCount = rawsCount;
    }
}
