package com.example.ragha.tawjihiresultapp;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.app.SearchManager;
import android.support.v7.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity  implements Adapter.onItemClickListener{

    public static final String Extra_year="year";
    public static final String Extra_name="name";
    public static final String Extra_school="school";
    public static final String Extra_section="section";


    private RecyclerView myRecyclerView;
    private Adapter myAdapter;
    private ArrayList<StudentGson> myItemList;
    private RequestQueue myRequestQueue;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        context = this;
        myItemList=new ArrayList<>();


    }
    public void Search(String s){
        OkHttpClient Client = new OkHttpClient();
        String url = "http://192.168.1.237:9000/search?s="+s;
        Gson gson=new Gson();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .build();

        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse=response.body().string();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            StudentGson[] students = new Gson().fromJson(myResponse, StudentGson[].class);
                            myItemList = new ArrayList<StudentGson>(Arrays.asList(students));
                            Adapter studentAdaper = new Adapter(context, myItemList);
                            studentAdaper.setOnItemClickListener(MainActivity.this);
                            myRecyclerView.setAdapter(studentAdaper);
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onItemClick(int position) {
        Intent detail_Intent=new Intent(this ,DetailActivity.class);
        StudentGson ClickedItem=myItemList.get(position);
        detail_Intent.putExtra(Extra_year,ClickedItem.getYear());
        detail_Intent.putExtra(Extra_name,ClickedItem.getName());
        detail_Intent.putExtra(Extra_section,ClickedItem.getSection());
        detail_Intent.putExtra(Extra_school,ClickedItem.getSchool());
        startActivity(detail_Intent);


    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //final Context co =this;
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String s) {
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
          Search(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
});
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int menuItemThatWasSelected=item.getItemId();
        return super.onOptionsItemSelected(item);
    }
   public  void showProgressDialog(){
        ProgressDialog Dialog = new ProgressDialog(this);
        Dialog.setMessage("Searching...");
        Dialog.setCancelable(false);
        Dialog.show();
    }
    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"on Start",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"on Resume",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"on Pause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"on Stop",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"on Destroy",Toast.LENGTH_SHORT).show();
    }
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"on Restart",Toast.LENGTH_SHORT).show();
    }
*/
}
