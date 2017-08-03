package br.com.xoyz.testrestgps.listview;

import android.widget.AbsListView;

import br.com.xoyz.testrestgps.rest.ListCheckController;

/**
 * Created by lelag on 30/07/2017.
 */

public class EndlessScrollListener implements AbsListView.OnScrollListener {

    private int visibleThreshold = 10;
    private int currentPage = 0;
    private int previousTotal = 0;
    private boolean loading = true;
    private ListAdapter adapter;


    public EndlessScrollListener() {
    }
    public EndlessScrollListener(int visibleThreshold, ListAdapter adapter) {
        this.visibleThreshold = visibleThreshold;
        this.adapter = adapter;
        fillChecks(currentPage, visibleThreshold);

    }

    private void fillChecks(int currentPage, int visibleThreshold){
        ListCheckController restController = new ListCheckController();
        restController.find(currentPage, visibleThreshold, adapter);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,  int visibleItemCount, int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // I load the next page of gigs using a background task,
            // but you can call any function here.
         //   new LoadGigsTask().execute(currentPage + 1);

            ListCheckController restController = new ListCheckController();
            restController.find(currentPage+1, visibleThreshold, adapter);
            loading = true;

        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
}