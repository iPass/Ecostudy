package com.ecostudy;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.ecostudy.common.ConnectionManager;
import com.ecostudy.common.Constants;

public class LoginActivity extends Activity implements OnClickListener {

	private Button btnLogin;
	private EditText txtUserId;
	private EditText txtPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		btnLogin = (Button) findViewById(R.id.btn_Login);
		txtUserId = (EditText) findViewById(R.id.userId);
		txtPassword = (EditText) findViewById(R.id.password);

		btnLogin.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class SendRequest extends
			AsyncTask<Map<String, String>, Integer, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Map<String, String>... params) {

			String reponseData = null;
			try {
				reponseData = ConnectionManager.sendPost(Constants.URL_API,
						params[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return reponseData;

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String response) {
			super.onPostExecute(response);
		}

	}

	@Override
	public void onClick(View v) {

		String userId;
		String password;

		userId = txtUserId.getText().toString();
		password = txtPassword.getText().toString();

		SendRequest upload = new SendRequest();

		HashMap<String, String> data = new HashMap<String, String>();
		data.put(Constants.API_NAME_KEY, Constants.API_LOGIN);
		data.put("email", userId);
		data.put("password", password);
		data.put("signature", "2411d9879ab70a1a0059b585c338ae9e");

		upload.execute(data);

		// Intent intent = new Intent(MainActivity.this, Master.class);
		// startActivity(intent);
	}
}
