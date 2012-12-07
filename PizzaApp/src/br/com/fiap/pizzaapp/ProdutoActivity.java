/**
 * 
 */
package br.com.fiap.pizzaapp;



import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Silvio
 *
 */
public class ProdutoActivity extends MapActivity implements OnClickListener{
	private MapView mapView;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		 mapView = (MapView)findViewById(R.id.mapId);
		 
	        mapView.setBuiltInZoomControls(true);
	        mapView.getController().setZoom(13);
	        mapView.setTraffic(true);
	        mapView.setSatellite(false);
	        
	       /* new RotaAsyncTask(mapView).execute(
	        		// Latitude, Logintude de Origem
	        		-23.589576,-46.634716, 
	        		// Latitude, Longitude de Destino
	        		-23.489576,-46.534716);*/
		Button localizar = (Button)findViewById(R.id.button1);
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
	
	@Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
            	/*AlertDialog.Builder dialog = new AlertDialog.Builder(this);
				dialog.setTitle("tempo");
				TextView textView = (TextView)findViewById(R.id.cepInicial);
				dialog.setMessage("teste:"+textView.getText());
				dialog.show();*/
            	
            	   new RotaAsyncTask(mapView).execute(
       	        		// Latitude, Logintude de Origem
       	        		-23.574534,-46.623169, 
       	        		// Latitude, Longitude de Destino
       	        		-23.589576,-46.634716);
            	   
            	   
                break;
            
        }
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
