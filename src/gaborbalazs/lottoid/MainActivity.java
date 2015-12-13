package gaborbalazs.lottoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private TextView drawnNumbersStatus;
	private ImageButton button1;
	private ImageButton button2;
	private ImageButton button3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawnNumbersStatus = (TextView) findViewById(R.id.textView1);
		button1 = (ImageButton) findViewById(R.id.imageButton1);
		button2 = (ImageButton) findViewById(R.id.imageButton2);
		button3 = (ImageButton) findViewById(R.id.imageButton3);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
	}

	public void onClick(View v) {
		if(v.getId() == R.id.imageButton1) {
			drawnNumbersStatus.setText(new LotteryGenerator(90, 5).toString());
		} else if(v.getId() == R.id.imageButton2) {
			drawnNumbersStatus.setText(new LotteryGenerator(45, 6).toString());
		} else if(v.getId() == R.id.imageButton3) {
			drawnNumbersStatus.setText(new LotteryGenerator(35, 7).toString());
		}
	}
}
