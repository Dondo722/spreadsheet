package org.example.Model;

public class PagesModel {

    private int currentPage = 1;
    private int lastPage = 1;
    private int rawsCount = -1;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getRawsCount() {
        return rawsCount;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void countLastPage(int maxRaws){
        if(rawsCount == -1 )return;
        this.setLastPage((int)(Math.ceil( maxRaws/((double) this.getRawsCount()))));
    }

    public void countCurrentPage(int num){
        for(int i = 0; i < lastPage; i ++){
            if (i * this.rawsCount <= num && (i+1) * this.rawsCount >= num)
                this.currentPage  = (i+1);
        }
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void setRawsCount(int rawsCount) {
        this.rawsCount = rawsCount;
    }



}
