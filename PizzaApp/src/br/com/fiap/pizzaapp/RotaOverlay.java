package br.com.fiap.pizzaapp;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class RotaOverlay extends Overlay {
	private Paint paint;
	private List<GeoPoint> geoPoints;
	
	public RotaOverlay(List<GeoPoint> geoPoints) {
		this.geoPoints = geoPoints;
		this.paint = new Paint();
		this.paint.setColor(Color.RED);
		this.paint.setStrokeWidth(5);
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
		
		Projection proj = mapView.getProjection();
		Point ponto1, ponto2;
		for (int i = 0; i < geoPoints.size() - 1; i++) {
			ponto1 = proj.toPixels(geoPoints.get(i), null);
			ponto2 = proj.toPixels(geoPoints.get(i+1), null);
			
			canvas.drawLine(ponto1.x, ponto1.y, ponto2.x, ponto2.y, paint);
		}
	}
}
