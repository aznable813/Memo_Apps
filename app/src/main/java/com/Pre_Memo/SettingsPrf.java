package com.Pre_Memo;
import android.app.*;
import android.os.*;
import android.preference.*;
import android.preference.Preference.*;
import android.content.*;

public class SettingsPrf extends PreferenceActivity {

	private SharedPreferences spf;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		spf = PreferenceManager.getDefaultSharedPreferences(this);
		if(!spf.getString(getString(R.string.K_Init),"").equals(StartUp.PREF_INIT_FLG)){
			InitSetings();
		}
		getFragmentManager().beginTransaction()
			.replace(android.R.id.content, new SettingFrgm(this))
			.commit();
	}
	
	protected void InitSetings(){
		SharedPreferences.Editor editor= spf.edit();
		editor.putString(getString(R.string.K_Startup),getString(R.string.activity_main));
		editor.putString(getString(R.string.K_Odr1),getString(R.string.Ent1_Odr));
		editor.putString(getString(R.string.K_Odr1_by),getString(R.string.Ent2_Odr_by));
		editor.putString(getString(R.string.K_Odr2),getString(R.string.Ent3_Odr));
		editor.putString(getString(R.string.K_Odr2_by),getString(R.string.Ent1_Odr_by));
		editor.putString(getString(R.string.K_Init),StartUp.PREF_INIT_FLG);
		editor.commit();
	}
} 
