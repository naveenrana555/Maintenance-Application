package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VhfRxEcilDailyActivity extends AppCompatActivity {
    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "VhfRxEcilDailyActivity"; //Change Here as per your class name
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_rx_ecil_daily);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119,
                editText120, editText121, editText122, editText123, editText124,editText125, editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138,
                editText139, editText140, editText141, editText142, editText143, editText144, editText145, editText146, editText147, editText148;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx1),
                editText4 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx2),
                editText5 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx3),
                editText6 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx4),
                editText7 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx5),
                editText8 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx6),
                editText9 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq1),
                editText10 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq2),
                editText11 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq3),
                editText12 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq4),
                editText13 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq5),
                editText14 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq6),
                editText15 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc1),
                editText16 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc2),
                editText17 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc3),
                editText18 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc4),
                editText19 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc5),
                editText20 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc6),
                editText21 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow1),
                editText22 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow2),
                editText23 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow3),
                editText24 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow4),
                editText25 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow5),
                editText26 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow6),
                editText27 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow1),
                editText28 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow2),
                editText29 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow3),
                editText30 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow4),
                editText31 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow5),
                editText32 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow6),
                editText33 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus1),
                editText34 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus2),
                editText35 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus3),
                editText36 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus4),
                editText37 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus5),
                editText38 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus6),
                editText39 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute1),
                editText40 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute2),
                editText41 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute3),
                editText42 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute4),
                editText43 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute5),
                editText44 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute6),
                editText45 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite1),
                editText46 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite2),
                editText47 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite3),
                editText48 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite4),
                editText49 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite5),
                editText50 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite6),
                editText51 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn1),
                editText52 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn2),
                editText53 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn3),
                editText54 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn4),
                editText55 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn5),
                editText56 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn6),
                editText57 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC1),
                editText58 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC2),
                editText59 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC3),
                editText60 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC4),
                editText61 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC5),
                editText62 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC6),
                editText63 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt1),
                editText64 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt2),
                editText65 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt3),
                editText66 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt4),
                editText67 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt5),
                editText68 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt6),
                editText69 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI1),
                editText70 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI2),
                editText71 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI3),
                editText72 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI4),
                editText73 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI5),
                editText74 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI6),
                editText75 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRemarks1),
                editText76 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx7),
                editText77 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx8),
                editText78 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx9),
                editText79 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx10),
                editText80 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx11),
                editText81 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRx12),
                editText82 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq7),
                editText83 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq8),
                editText84 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq9),
                editText85 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq10),
                editText86 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq11),
                editText87 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyFreq12),
                editText88 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc7),
                editText89 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc8),
                editText90 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc9),
                editText91 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc10),
                editText92 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc11),
                editText93 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyLoc12),
                editText94 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow7),
                editText95 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow8),
                editText96 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow9),
                editText97 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow10),
                editText98 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow11),
                editText99 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACPow12),
                editText100 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow7),
                editText101 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow8),
                editText102 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow9),
                editText103 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow10),
                editText104 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow11),
                editText105 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCPow12),
                editText106 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus7),
                editText107 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus8),
                editText108 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus9),
                editText109 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus10),
                editText110 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus11),
                editText111 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyStatus12),
                editText112 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute7),
                editText113 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute8),
                editText114 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute9),
                editText115 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute10),
                editText116 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute11),
                editText117 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyMute12),
                editText118 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite7),
                editText119 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite8),
                editText120 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite9),
                editText121 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite10),
                editText122 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite11),
                editText123 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyBite12),
                editText124 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn7),
                editText125 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn8),
                editText126 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn9),
                editText127 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn10),
                editText128 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn11),
                editText129 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRxn12),
                editText130 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC7),
                editText131 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC8),
                editText132 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyACDC9),
                editText133 = (EditText)  findViewById(R.id.editTextVhfRxEcilDailyACDC10),
                editText134 = (EditText)  findViewById(R.id.editTextVhfRxEcilDailyACDC11),
                editText135 = (EditText)  findViewById(R.id.editTextVhfRxEcilDailyACDC12),
                editText136 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt7),
                editText137 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt8),
                editText138 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt9),
                editText139 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt10),
                editText140 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt11),
                editText141 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyDCVolt12),
                editText142 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI7),
                editText143 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI8),
                editText144 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI9),
                editText145 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI10),
                editText146 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI11),
                editText147 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRSSI12),
                editText148 = (EditText) findViewById(R.id.editTextVhfRxEcilDailyRemarks2)};

    //---------------------To Set View in Current Activity------------------
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView10 = (TextView) findViewById(R.id.textView118);
        textView10.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setText("Location: " + MainActivity.latLong1);

        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        String strData = sdf.format(calendar.getTime());
        textViewDate.setText(strData);

        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11) ;
        Button submitSchedule = (Button) findViewById(R.id.button10);

        submitSchedule.setVisibility(android.view.View.INVISIBLE);
        signDocument.setVisibility(android.view.View.VISIBLE);

        signDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySignature.dialog_action(submitSchedule, signDocument);


            }
        });

        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF();
            }
        });
        // Fixed for all activity-------------------------------------------------------------------

    }
    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);


//        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);
//
//        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1024, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhfrxecildaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {168,488,253,323,396,466,535,607,253,323,396,466,535,607,253,323,396,466,535,607,253,323,396,466,535,607,
                253,323,396,466,535,607,253,323,396,466,535,607,253,323,396,466,535,607,253,323,396,466,535,607,253,323,396,466,535,607,
                253,323,396,466,535,607,253,323,396,466,535,607,253,323,396,466,535,607,162};
        int[] editTextYPixel = {205,207,275,275,275,275,275,275,304,304,304,304,304,304,335,335,335,335,335,335,394,394,394,394,394,394,
                423,423,423,423,423,423,455,455,455,455,455,455,485,485,485,485,485,485,513,513,513,513,513,513,548,548,548,548,548,548,
                588,588,588,588,588,588,628,628,628,628,628,628,656,656,656,656,656,656,698};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }


    /*    for(int i = 0; i < spinnerDataForPDF.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel[i],spinnerYPixel[i],titlePaint);
        }
*/

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,481,225,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhfrxecildaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {257,326,395,464,536,607,257,326,395,464,536,607,257,326,395,464,536,607,257,326,395,464,536,607,257,326,395,464,536,607,
                                 257,326,395,464,536,607,257,326,395,464,536,607,257,326,395,464,536,607,257,326,395,464,536,607,257,326,395,464,536,607,
                                 257,326,395,464,536,607,257,326,395,464,536,607,163};
        int[] editTextYPixel2 = {122,122,122,122,122,122,151,151,151,151,151,151,181,181,181,181,181,181,242,242,242,242,242,242,272,272,272,272,272,272,
                                 306,306,306,306,306,306,336,336,336,336,336,336,363,363,363,363,363,363,399,399,399,399,399,399,438,438,438,438,438,438,
                                 477,477,477,477,477,477,509,509,509,509,509,509,545};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 83, 632, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFRxEcil/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily VHF RX ECIL " + strData + ".pdf"; // Change Here--------------------------
        String targetPdf = directory_path + fileName;
        File filePath = new File(targetPdf);
        try {
            myPdfdocument.writeTo(new FileOutputStream(filePath));
            //Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
            //done = true;
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        myPdfdocument.close();
        String specificCode = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());// Change Here----------------------------
        //This function saves all the data to parse Server
        //myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"VHF","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of ECIL VHF Rx done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);


        myFunctions.toLogoutActivity();
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final EditText desiredFormName = (EditText)mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view = findViewById(R.id.putInDB);
                        String formName = desiredFormName.getText().toString();
                        myFunctions.addToDB(view ,editTextArray,switchArray,spinnerArray,formName, thisActivityName);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;

            case R.id.deleteFromDB:
                View view1 = findViewById(R.id.deleteFromDB);
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete Alert")
                        .setMessage("Do you really want to delete this entry permanently from Local DB?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myFunctions.deleteFromDB(view1, selectedID, selectedName);
                                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }

    //----At last don't forget to put an entry in Switch Case of ListDataActivity.java------------
}