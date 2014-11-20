package com.whiterabbitplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Intents;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ContactInserter extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_inserter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_inserter, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void insertContact(String name, String email, String secondEmail, String phone, String secondPhone, String notes, String postal) {
	    Intent intent = new Intent(Intent.ACTION_INSERT);
	    intent.setType(Contacts.CONTENT_TYPE);
	    intent.putExtra(Intents.Insert.NAME, name);
	    intent.putExtra(Intents.Insert.EMAIL, email);
	    intent.putExtra(Intents.Insert.SECONDARY_EMAIL, secondEmail);
	    intent.putExtra(Intents.Insert.PHONE, phone);
	    intent.putExtra(Intents.Insert.SECONDARY_PHONE, secondPhone);
	    intent.putExtra(Intents.Insert.NOTES, notes);
	    intent.putExtra(Intents.Insert.POSTAL, postal);
	    if (intent.resolveActivity(getPackageManager()) != null) {
	        startActivity(intent);
	    }
	}
	
	public void showSoftKeyboard(View view) {
	    if (view.requestFocus()) {
	        InputMethodManager imm = (InputMethodManager)
	                getSystemService(Context.INPUT_METHOD_SERVICE);
	        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
	    }
	}
	
}
