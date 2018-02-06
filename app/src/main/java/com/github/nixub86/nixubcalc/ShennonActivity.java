package com.github.nixub86.nixubcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class ShennonActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String editShennon;
    EditText editTShennon;
    TextView textVShennon;
    CheckBox checkBoxShennon;
    EditText editTNSShennon;
    int[] numberofletter = new int[36];
    char[] charofletters = new char[36];
    String outputText;
    String editNSShennon;
    double H;
    double NS;
    Boolean checkSpaces;
    int StringLength;
    int numberOfSpaces;
    double Pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shennon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        charofletters = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
                'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
                'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' '};
        outputText = "Буквы: ";
        editNSShennon = "";
        H=0;
        checkSpaces = false;
        numberOfSpaces = 0;
        Pi = 0.0;
        NS = 0.0;

        editTShennon = (EditText)  findViewById(R.id.editTextShennon);
        editTNSShennon = (EditText) findViewById(R.id.editTextNSShennon);
        checkBoxShennon= (CheckBox) findViewById(R.id.checkBoxSpacesShennon);
        textVShennon = (TextView)  findViewById(R.id.textViewShennon);
        textVShennon.setMovementMethod(new ScrollingMovementMethod());

        Button CalcButtonShennon = (Button) findViewById(R.id.CalcButtonShennon);
        CalcButtonShennon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfSpaces = 0;
                Pi = 0.0;
                H=0.0;
                numberofletter = new int[36];
                //textVShennon.setText(null);
                outputText = "Буквы: ";
                editShennon = editTShennon.getText().toString();
                editNSShennon = editTNSShennon.getText().toString();
                editNSShennon = editNSShennon.replace(",",".");
                editNSShennon = editNSShennon.replaceAll("[^0-9.]","");
                NS = Double.parseDouble(editNSShennon);
                System.out.println("Система счисления: " + NS);
                System.out.println("Введенно: " + editShennon);
                editShennon = editShennon.toLowerCase();
                System.out.println("Переведенно в нижний регистр: " + editShennon);
                checkSpaces = checkBoxShennon.isChecked();
                StringLength = editShennon.length();
                for (char element : editShennon.toCharArray()){
                    if (element == charofletters[0]) numberofletter[0]++;
                    if (element == charofletters[1]) numberofletter[1]++;
                    if (element == charofletters[2]) numberofletter[2]++;
                    if (element == charofletters[3]) numberofletter[3]++;
                    if (element == charofletters[4]) numberofletter[4]++;
                    if (element == charofletters[5]) numberofletter[5]++;
                    if (element == charofletters[6]) numberofletter[6]++;
                    if (element == charofletters[7]) numberofletter[7]++;
                    if (element == charofletters[8]) numberofletter[8]++;
                    if (element == charofletters[9]) numberofletter[9]++;
                    if (element == charofletters[10]) numberofletter[10]++;
                    if (element == charofletters[11]) numberofletter[11]++;
                    if (element == charofletters[12]) numberofletter[12]++;
                    if (element == charofletters[13]) numberofletter[13]++;
                    if (element == charofletters[14]) numberofletter[14]++;
                    if (element == charofletters[15]) numberofletter[15]++;
                    if (element == charofletters[16]) numberofletter[16]++;
                    if (element == charofletters[17]) numberofletter[17]++;
                    if (element == charofletters[18]) numberofletter[18]++;
                    if (element == charofletters[19]) numberofletter[19]++;
                    if (element == charofletters[20]) numberofletter[20]++;
                    if (element == charofletters[21]) numberofletter[21]++;
                    if (element == charofletters[22]) numberofletter[22]++;
                    if (element == charofletters[23]) numberofletter[23]++;
                    if (element == charofletters[24]) numberofletter[24]++;
                    if (element == charofletters[25]) numberofletter[25]++;
                    if (element == charofletters[26]) numberofletter[26]++;
                    if (element == charofletters[27]) numberofletter[27]++;
                    if (element == charofletters[28]) numberofletter[28]++;
                    if (element == charofletters[29]) numberofletter[29]++;
                    if (element == charofletters[30]) numberofletter[30]++;
                    if (element == charofletters[31]) numberofletter[31]++;
                    if (element == charofletters[32]) numberofletter[32]++;
                    if (element == charofletters[33]) numberofletter[33]++;
                    //if (element == charofletters[34]) numberofletter[34]++;
                }
                for (int i = 0; i < numberofletter.length-1; i++) {
                    if (numberofletter[i] > 0 && charofletters[i] == ' ') {
                        numberOfSpaces = numberofletter[i];
                    }
                }
                System.out.println("Длина строки: " + StringLength);
                System.out.println("Пробелы: " + numberOfSpaces);
                System.out.println("Проверять пробелы: " + checkSpaces);
                if (!checkSpaces) {
                    StringLength = StringLength - numberOfSpaces;
                }
                System.out.println("Длина строки - пробелы: " + StringLength);
                for (int i = 0; i < numberofletter.length-1; i++) {
                    if (numberofletter[i] > 0) {
                        if (checkSpaces && charofletters[i] == ' ') {
                            Pi = (double) numberofletter[i] / (double) StringLength;
                            outputText = outputText + "\n" + "Пробелы: " + numberofletter[i];
                            H = H - ((double) numberofletter[i] / (double) StringLength)
                                    * NXBMathUtils.logb((double) numberofletter[i] / (double) StringLength, NS);
                        } else if (charofletters[i] != ' '){
                            Pi = (double) numberofletter[i] / (double) StringLength;
                            outputText = outputText + "\n" + charofletters[i] + ": " + numberofletter[i] + "  Pi=" + Pi;
                            H = H - (Pi) * NXBMathUtils.logb((double) numberofletter[i] / (double) StringLength, NS);
                        }
                    }
                }
                System.out.println(H);
                textVShennon.setText("Введённая строка: " + editShennon + "\n" + outputText + "\n N: " + StringLength + "\n H: " + H);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shennon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent shennon = new Intent(this, ShennonActivity.class);
        Intent settings = new Intent(this, SettingsActivity.class);
        Intent arctan = new Intent(this, ArctanActivity.class);
        Intent combination = new Intent(this, Combination.class);

        if (id == R.id.nav_shennon) {
            startActivity(shennon);
        } else if (id == R.id.nav_settings) {
            startActivity(settings);
        } else if (id == R.id.nav_arctan) {
            startActivity(arctan);
        } else if (id == R.id.nav_combination){
            startActivity(combination);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
