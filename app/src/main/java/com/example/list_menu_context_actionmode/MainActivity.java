package com.example.list_menu_context_actionmode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    ConstraintLayout rela;
    ArrayList<CountriesModel> countriesData;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        listView = findViewById(R.id.listView);
        rela = (ConstraintLayout) findViewById(R.id.rela);
        countriesData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();

        customAdapter = new CustomAdapter(context, countriesData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, countriesData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Cập nhật");
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu, menu);
    }

        public boolean onContextItemSelected(MenuItem item){
            switch (item.getItemId()) {
                case R.id.them:
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.sua:
                    Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.xoa:
                    Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                return super.onContextItemSelected(item);
            }
        }

    private void populateCountriesData() {
        //music1
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setName("Mascara");
        countriesModel.setImage(R.drawable.mascara);
        countriesModel.setArea("1,005,300");
        countriesModel.setPopulation("Chillies");
        countriesData.add(countriesModel);

        //music2
        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("Skyfall");
        countriesModel.setImage(R.drawable.skyfall);
        countriesModel.setArea("2,543,578,998");
        countriesModel.setPopulation("Adele");
        countriesData.add(countriesModel);

        //music3
        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Home");
        countriesModel.setImage(R.drawable.home);
        countriesModel.setArea("3,287,260");
        countriesModel.setPopulation("Michael Balack");
        countriesData.add(countriesModel);

        //music4
        countriesModel = new CountriesModel();
        countriesModel.setId(4);
        countriesModel.setName("Saturn");
        countriesModel.setImage(R.drawable.saturn);
        countriesModel.setArea("1,241,610,000");
        countriesModel.setPopulation("Sleeping At Last");
        countriesData.add(countriesModel);

        //music5
        countriesModel = new CountriesModel();
        countriesModel.setId(5);
        countriesModel.setName("Lovely");
        countriesModel.setImage(R.drawable.lovely);
        countriesModel.setArea("500,548,229");
        countriesModel.setPopulation("Billie Eilish");
        countriesData.add(countriesModel);

        //music6
        countriesModel = new CountriesModel();
        countriesModel.setId(6);
        countriesModel.setName("You Broke Me First");
        countriesModel.setImage(R.drawable.youbrokemefirst);
        countriesModel.setArea("800,256,111");
        countriesModel.setPopulation("Luca Schreiner");
        countriesData.add(countriesModel);

        //music7
        countriesModel = new CountriesModel();
        countriesModel.setId(7);
        countriesModel.setName("Lie To Me");
        countriesModel.setImage(R.drawable.lietome);
        countriesModel.setArea("700,211,121");
        countriesModel.setPopulation("Ali Atie");
        countriesData.add(countriesModel);

        //music8
        countriesModel = new CountriesModel();
        countriesModel.setId(7);
        countriesModel.setName("Warm On Cold Night");
        countriesModel.setImage(R.drawable.warmoncoldnight);
        countriesModel.setArea("230,551,812");
        countriesModel.setPopulation("Honnie");
        countriesData.add(countriesModel);

    }
}