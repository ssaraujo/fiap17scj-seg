/**
 * 
 */
package br.com.fiap.pizzaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Silvio
 *
 */
public class EnderecoActivity extends Activity implements OnClickListener{
	//teste silvio666
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endereco);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		Button localizar = (Button)findViewById(R.id.btEnderecoLocalizar);
		localizar.setOnClickListener(this);
		

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	public void onStart() {
		super.onStart();
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	public void onResume() {
		super.onResume();
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	public void onPause() {
		super.onPause();
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	public void onStop() {
		super.onStop();
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		// TODO Auto-generated method stub

	}
	
	private void buscaEndereco(String ruaOrigem,String numeroOrigem, String cepOrigem,String ruaDestino,String numeroDestino, String cepDestino){
		
		StringBuilder response = new StringBuilder();
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("http://maps.googleapis.com/maps/api/directions/json?origin=");
		urlBuilder.append(ruaOrigem.replace(" ", "."));
		urlBuilder.append(",");
		urlBuilder.append(numeroOrigem);
		urlBuilder.append(".");
		urlBuilder.append(cepOrigem);
		urlBuilder.append("&destination=");
		urlBuilder.append(ruaDestino.replace(" ", "."));
		urlBuilder.append(",");
		urlBuilder.append(numeroDestino);
		urlBuilder.append(".");
		urlBuilder.append(cepDestino);
		urlBuilder.append("&sensor=false");
		
	      URL url;
		try {
			url = new URL(urlBuilder.toString());
			  HttpURLConnection httpconn = (HttpURLConnection)url.openConnection();
		      if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK)
		      {
		          BufferedReader input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()),8192);
		          String strLine = null;
		          while ((strLine = input.readLine()) != null)
		          {
		              response.append(strLine);
		          }
		          input.close();
		      }
		      String jsonOutput = response.toString();
		     
		      JSONObject jsonObject = new JSONObject( response.toString());

				// routesArray contains ALL routes
				JSONArray routesArray = jsonObject.getJSONArray("routes");
				// Grab the first route
				JSONObject route = routesArray.getJSONObject(0);
				// Take all legs from the route
				JSONArray legs = route.getJSONArray("legs");
				// Grab first leg
				JSONObject leg = legs.getJSONObject(0);

				JSONObject durationObject = leg.getJSONObject("duration");
				String duration = durationObject.getString("text");				
				
				JSONObject distanceObject = leg.getJSONObject("distance");
				String distance = distanceObject.getString("text");
				
				
				JSONObject end_locationObject = leg.getJSONObject("end_location");
				String end_location_lat = end_locationObject.getString("lat");
				String end_location_lng = end_locationObject.getString("lng");
				
				JSONObject start_locationObject = leg.getJSONObject("start_location");
				String start_location_lat = start_locationObject.getString("lat");
				String start_location_lng = start_locationObject.getString("lng");
				
				Intent intent = new Intent(this, MapaActivity.class);    
				intent.putExtra("duration", duration);
				intent.putExtra("distance", distance);
				intent.putExtra("end_location_lat", end_location_lat);
				intent.putExtra("end_location_lng", end_location_lng);
				intent.putExtra("start_location_lat", start_location_lat);
				intent.putExtra("start_location_lng", start_location_lng);
				
		        this.startActivity(intent);
		        this.finish();
				
			/*	AlertDialog.Builder dialog = new AlertDialog.Builder(this);
				dialog.setTitle("tempo");
				dialog.setMessage(duration);
				dialog.show();*/
				
		} catch (MalformedURLException e) {
			 Log.e("NGVL", e.getMessage(), e);
		} catch (IOException e) {
			 Log.e("NGVL", e.getMessage(), e);
		} catch (JSONException e) {
			 Log.e("NGVL",  e.getMessage(), e);
		}
		
	}

	
	@Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btEnderecoLocalizar:
            	/*AlertDialog.Builder dialog = new AlertDialog.Builder(this);
				dialog.setTitle("tempo");
				TextView textView = (TextView)findViewById(R.id.cepInicial);
				dialog.setMessage("teste:"+textView.getText());
				dialog.show();*/
            	TextView enderecoInicial = (TextView)findViewById(R.id.enderecoInicial);
            	TextView numeroInicial = (TextView)findViewById(R.id.numeroInicial);
            	TextView cepInicial = (TextView)findViewById(R.id.cepInicial);
            	TextView enderecoFinal = (TextView)findViewById(R.id.enderecoFinal);
            	TextView numeroFinal = (TextView)findViewById(R.id.numeroFinal);
            	TextView cepFinal = (TextView)findViewById(R.id.cepFinal);
            	buscaEndereco(enderecoInicial.getText().toString(),
            			numeroInicial.getText().toString(),
            			cepInicial.getText().toString(),
            			enderecoFinal.getText().toString(),
            			numeroFinal.getText().toString(),
            			cepFinal.getText().toString());
            	   
            	   
                break;
            
        }
    }

}
