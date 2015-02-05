package co.ke.softwareproviders.fanikiwagl;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity; 
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;    
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView; 
import android.widget.ImageButton;
import android.widget.TextView;  
import android.view.View.OnClickListener;

public class StaticPostingActivity extends ActionBarActivity {

	 
	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    ImageButton imageButton;
    Button listButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.static_posting_activity);
 
		 imageButton = (ImageButton) findViewById(R.id.btnimg);

	        imageButton.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View arg0) {

	                new AsyncTaskLoadImage().execute();

	            }

	        });
	        listButton = (Button) findViewById(R.id.btnList);

	        listButton.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View arg0) {

	                new AsyncTaskLoadList().execute();

	            }

	        });
       
    }
    private class AsyncTaskLoadImage extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */
        @Override
        protected void onPostExecute(Void result) {
 
            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            Drawable drawable = getResources().getDrawable(R.drawable.cert);
            imgView.setImageDrawable(drawable);
 
            Toast.makeText(StaticPostingActivity.this,
                    "Photo was loaded Asynchronously!", Toast.LENGTH_SHORT).show();

        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPreExecute()
         */
        @Override
        protected void onPreExecute() {
            // Things to be done before execution of long running operation. For
            // example showing ProgessDialog
        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onProgressUpdate(Progress[])
         */
       /* @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);
            // Things to be done while execution of long running operation is in
            // progress. For example updating ProgessDialog
        }*/
    }
    
    private class AsyncTaskLoadList extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */
        @Override
        protected void onPostExecute(Void result) {

        	 // get the listview
            expListView = (ExpandableListView) findViewById(R.id.lvExp);     
            // preparing list data
            prepareListData();     
            listAdapter = new ExpandableListAdapter(StaticPostingActivity.this, listDataHeader, listDataChild);     
            // setting list adapter
            expListView.setAdapter(listAdapter);
             

            Toast.makeText(StaticPostingActivity.this,
                    "List was loaded Asynchronously!", Toast.LENGTH_SHORT).show();

        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onPreExecute()
         */
        @Override
        protected void onPreExecute() {
            // Things to be done before execution of long running operation. For
            // example showing ProgessDialog
        }

        /*
         * (non-Javadoc)
         *
         * @see android.os.AsyncTask#onProgressUpdate(Progress[])
         */
       /* @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);
            // Things to be done while execution of long running operation is in
            // progress. For example updating ProgessDialog
        }*/
    }
    
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");
 
        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");
 
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");
 
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");
 
        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
    
    public void LoadPhoto() {
    	ImageView imgView = (ImageView) findViewById(R.id.imageView);
        Drawable drawable = getResources().getDrawable(R.drawable.cert);
        imgView.setImageDrawable(drawable);

    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.static_posting, menu);
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
}
