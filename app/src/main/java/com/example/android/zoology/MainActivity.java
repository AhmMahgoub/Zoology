package com.example.android.zoology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton first_answer ;
    RadioButton second_answer ;
    RadioButton third_answer ;
    RadioButton fourth_answer ;
    CheckBox fifth_answer_a1 ;
    CheckBox fifth_answer_a2 ;
    CheckBox fifth_wrong_a1 ;
    CheckBox fifth_wrong_a2 ;
    CheckBox sixth_answer_a1 ;
    CheckBox sixth_answer_a2 ;
    CheckBox sixth_wrong_a1 ;
    CheckBox sixth_wrong_a2 ;
    int correct_answer = 0 ;
    int checkbox_sum  ;
    int score_question_five ;
    int score_question_six ;
    String right_text_answer = "cheetah";

    public int calculate_checkbox_score(){

        fifth_answer_a1 = (CheckBox)findViewById(R.id.checkbox_q5_a1);
        Boolean fifth_answer_a1_checked = fifth_answer_a1.isChecked();

        fifth_answer_a2 = (CheckBox)findViewById(R.id.checkbox_q5_a3);
        Boolean fifth_answer_a2_checked = fifth_answer_a2.isChecked();

        fifth_wrong_a1 = (CheckBox)findViewById(R.id.checkbox_q5_a2);
        Boolean fifth_wrong_a1_checked = fifth_wrong_a1.isChecked();

        fifth_wrong_a2 = (CheckBox)findViewById(R.id.checkbox_q5_a4);
        Boolean fifth_wrong_a2_checked = fifth_wrong_a2.isChecked();

        /*get the values for checkbox correct choices and wrong choices
        *for question number five
        */
        sixth_answer_a1 = (CheckBox)findViewById(R.id.checkbox_q6_a1);
        Boolean sixth_answer_a1_checked = sixth_answer_a1.isChecked();

        sixth_answer_a2 = (CheckBox)findViewById(R.id.checkbox_q6_a4);
        Boolean sixth_answer_a2_checked = sixth_answer_a1.isChecked();

        sixth_wrong_a1 = (CheckBox)findViewById(R.id.checkbox_q6_a2);
        Boolean sixth_wrong_a1_checked = sixth_wrong_a1.isChecked();

        sixth_wrong_a2 = (CheckBox)findViewById(R.id.checkbox_q6_a3);
        Boolean sixth_wrong_a2_checked = sixth_wrong_a2.isChecked();

        /*checkbox for  question number 5
        *check if the user choose more than two choices will get zero points
        * check if choose two choices correct will get 2 points
        */
        if( fifth_answer_a1_checked && fifth_answer_a2_checked && !fifth_wrong_a1_checked && !fifth_wrong_a2_checked)
        {
            score_question_five = 2;
        }
        else{
            score_question_five = 0 ;
        }

        /* checkbox for question number 6
        *check if the user choose more than two choices will get zero points
        * check if choose two choices correct will get 2 points
        */
        if( sixth_answer_a1_checked && sixth_answer_a2_checked  && !sixth_wrong_a1_checked && !sixth_wrong_a2_checked)
        {
                score_question_six = 2;
        }
        else{
            score_question_six = 0 ;
        }

        checkbox_sum += score_question_five;
        checkbox_sum += score_question_six;
        return checkbox_sum ;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

      public void onClickSubmit(View view){

        // get the name of the participant
          EditText nameField = (EditText) findViewById(R.id.insert_name);
          String name = nameField.getText().toString();

        //get the values for radio buttons correct choices
          first_answer = (RadioButton)findViewById(R.id.radio_q1_a3);
          second_answer = (RadioButton)findViewById(R.id.radio_q2_a2);
          third_answer = (RadioButton)findViewById(R.id.radio_q3_a2);
          fourth_answer = (RadioButton)findViewById(R.id.radio_q4_a1);

          //get the answer text from the user and store it in string
          EditText answer_Field = (EditText) findViewById(R.id.text_answer_q7);
          String text_answer = answer_Field.getText().toString();

         //compare the right answer
          if(text_answer.equals(right_text_answer))
          {
              correct_answer+=2;
          }
          //check the correct value and increment by 1 for radio buttons
          if(first_answer.isChecked()){
              correct_answer++;
          }
          if(second_answer.isChecked()){
              correct_answer++;
          }
          if(third_answer.isChecked()){
              correct_answer++;
          }
          if(fourth_answer.isChecked()){
              correct_answer++;
          }

          int final_result = calculate_checkbox_score();
          correct_answer += final_result ;

          //show the result
          Toast.makeText(this, name + " , You have " + correct_answer + " of 10 points " , Toast.LENGTH_LONG).show();

          finish();
          startActivity(getIntent());
      }
}
