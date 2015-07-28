package jonpi.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2Activity extends ActionBarActivity implements View.OnClickListener {
    private Button convert,nactic;
    private TextView tmpnumber;
    private EditText degreesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        init();
    }

    private void init() {
        convert = (Button) findViewById(R.id.convert);
        tmpnumber = (TextView) findViewById(R.id.tmpnumber);
        degreesc = (EditText) findViewById(R.id.degreesc);
        nactic =(Button)findViewById(R.id.nactic);

        convert.setOnClickListener(this);
        nactic.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    @Override
    public void onClick(View v) {
        String degs = degreesc.getText().toString();
        char tmp = 0x00B0;
        switch (v.getId()) {
            case R.id.convert:
                int conv = Integer.parseInt(degs) * 9 / 5 + 32;
                tmpnumber.setText(String.valueOf(conv) + tmp + "F");
                Toast tst = Toast.makeText(getApplicationContext(), String.valueOf(conv) + tmp + "F", Toast.LENGTH_LONG);
                tst.show();
                break;
            case R.id.nactic:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;

        }
    }
}
