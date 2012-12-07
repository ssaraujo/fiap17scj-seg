package br.com.fiap.pizzaapp;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class MainActivity extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);

		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
		HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(
				drawable, this);
		GeoPoint point = new GeoPoint((int)(-23.574534*1000000.0),(int)(-46.623169*1000000.0));
		
		OverlayItem overlayitem = new OverlayItem(point,
				"Laissez les bon temps rouler!", "I'm in Louisiana!");

		GeoPoint point2 = new GeoPoint((int)(-23.589576*1000000.0),(int)(-46.634716*1000000.0));
		OverlayItem overlayitem2 = new OverlayItem(point2, "Namashkaar!",
				"I'm in Hyderabad, India!");

		itemizedoverlay.addOverlay(overlayitem);
		itemizedoverlay.addOverlay(overlayitem2);

		mapOverlays.add(itemizedoverlay);
		
		StringBuilder response = new StringBuilder();
		 String stringUrl = "http://maps.googleapis.com/maps/api/directions/json?origin=-23.574534,-46.623169&destination=-23.589576,-46.634716&sensor=false";

	      URL url;
		try {
			url = new URL(stringUrl);
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
				
				AlertDialog.Builder dialog = new AlertDialog.Builder(this);
				dialog.setTitle("tempo");
				dialog.setMessage(duration);
				dialog.show();
				
		} catch (MalformedURLException e) {
			 Log.e("NGVL", e.getMessage(), e);
		} catch (IOException e) {
			 Log.e("NGVL", e.getMessage(), e);
		} catch (JSONException e) {
			 Log.e("NGVL",  e.getMessage(), e);
		}
		
		
	}
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	private String toString(InputStream is) 
			  throws IOException{

			  byte[] bytes = new byte[1024];
			  ByteArrayOutputStream baos = 
			    new ByteArrayOutputStream();
			  int lidos;
			  while ((lidos = is.read(bytes)) > 0){
			    baos.write(bytes, 0, lidos);
			  }
			  return new String(baos.toByteArray());
			}
	public String getRESTFileContent(String url) {
		  HttpClient httpclient = new DefaultHttpClient();
		  HttpGet httpget = new HttpGet(url);

		  try {
		    HttpResponse response = 
		      httpclient.execute(httpget);

		    HttpEntity entity = response.getEntity();

		    if (entity != null) {
		      InputStream instream = entity.getContent();
		      String result = toString(instream);

		      instream.close();
		      return result;
		    }
		  } catch (Exception e) {
		    Log.e("NGVL", "Falha ao acessar Web service", e);
		  }
		  return null;
		}

/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/

}
