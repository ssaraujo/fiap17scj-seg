/**
 * 
 */
package br.com.fiap.pizzaapp;


import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * @author Silvio
 *
 */
public class MapaActivity extends MapActivity implements OnClickListener{
	private MapView mapView;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		Bundle bundle = getIntent().getExtras();		
		CharSequence distance=new String(bundle.getString("distance"));
		CharSequence duration=new String(bundle.getString("duration"));		
				
		TextView distancia = (TextView)findViewById(R.id.txMapaDistancia);
		distancia.setText(distance);
		TextView tempo = (TextView)findViewById(R.id.txMapaTempo);
		tempo.setText(duration);
		
		
		 mapView = (MapView)findViewById(R.id.mapId);
		 
	        mapView.setBuiltInZoomControls(true);
	        mapView.getController().setZoom(13);
	        mapView.setTraffic(true);
	        mapView.setSatellite(false);	       
			
			double latitudeOrigem=Double.parseDouble(bundle.getString("start_location_lat"));
			double longitudeOrigem=Double.parseDouble(bundle.getString("start_location_lng"));
			double latitudeDestino=Double.parseDouble(bundle.getString("end_location_lat"));
			double longitudeDestino=Double.parseDouble(bundle.getString("end_location_lng"));
			new RotaAsyncTask(mapView).execute(
	        		// Latitude, Logintude de Origem
					latitudeOrigem,longitudeOrigem, 
	        		// Latitude, Longitude de Destino
					latitudeDestino,longitudeDestino);			
		
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



	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
    public void onClick(View v) {       
        Intent intent = new Intent(this, ProdutoActivity.class);         
        this.startActivity(intent);
        this.finish();
            
        
    }

}
