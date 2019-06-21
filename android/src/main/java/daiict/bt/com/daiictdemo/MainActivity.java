package daiict.bt.com.daiictdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    Web3j web3 = null;
    private String url = CommonConstants.NODE_URL_KOVAN;
    Credentials userWallet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public MainActivity() {

        if (web3 == null) {

            web3 = Web3j.build(new HttpService(url));
            userWallet = Credentials.create("6976494aa09a3b986784ba3027b492454ad511155136f3be6d06e89f2e698aec");;
            this.url = url;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void blockNumber(View view) throws Exception {
        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog at image upload time.
                //progressDialog = ProgressDialog.show(MainActivity.this, "Connecting to blockchain @" + eth.getethUrl(), CommonConstants.PLEASE_WAIT, false, false);
                //progressDialog.show();
            }

            @Override
            protected void onPostExecute(final String returnVal) {
                super.onPostExecute(returnVal);

                if (!"error".equals(returnVal)) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.blockNo),
                            returnVal, Snackbar.LENGTH_LONG);
                    mySnackbar.show();
                }
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    BigInteger blNo =  web3.ethBlockNumber().send().getBlockNumber();
                    return blNo.toString();
                } catch (Throwable e) {

                    e.printStackTrace();
                }
                return "error";

            }

        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
    }


    public void addEmployee(View view) throws Exception {
        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog at image upload time.
                //progressDialog = ProgressDialog.show(MainActivity.this, "Connecting to blockchain @" + eth.getethUrl(), CommonConstants.PLEASE_WAIT, false, false);
                //progressDialog.show();
            }

            @Override
            protected void onPostExecute(final String returnVal) {
                super.onPostExecute(returnVal);

                if (!"error".equals(returnVal)) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.blockNo),
                            returnVal, Snackbar.LENGTH_LONG);
                    mySnackbar.show();
                }
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    StructsArray contract = StructsArray.load(CommonConstants.STRUCTSARRAY_ADDRESS, web3, userWallet,
                            new DefaultGasProvider());
                    RemoteCall<TransactionReceipt> call = contract.addEmployee(new Utf8String("jill"), new Uint256(43));
                    TransactionReceipt t = call.send();
                    return t.getTransactionHash();
                } catch (Throwable e) {

                    e.printStackTrace();
                }
                return "error";

            }

        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
    }


    public void getEmployeeCount(View view) throws Exception {
        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog at image upload time.
                //progressDialog = ProgressDialog.show(MainActivity.this, "Connecting to blockchain @" + eth.getethUrl(), CommonConstants.PLEASE_WAIT, false, false);
                //progressDialog.show();
            }

            @Override
            protected void onPostExecute(final String returnVal) {
                super.onPostExecute(returnVal);

                if (!"error".equals(returnVal)) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.blockNo),
                            returnVal, Snackbar.LENGTH_LONG);
                    mySnackbar.show();
                }
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    StructsArray contract = StructsArray.load(CommonConstants.STRUCTSARRAY_ADDRESS, web3, userWallet,
                            new DefaultGasProvider());
                    Uint256 t = contract.getEmployeeCount().send();

                    return "Employee Count :"+t.getValue();
                } catch (Throwable e) {

                    e.printStackTrace();
                }
                return "error";

            }

        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
    }

    public void getEmployee(View view) throws Exception {
        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog at image upload time.
                //progressDialog = ProgressDialog.show(MainActivity.this, "Connecting to blockchain @" + eth.getethUrl(), CommonConstants.PLEASE_WAIT, false, false);
                //progressDialog.show();
            }

            @Override
            protected void onPostExecute(final String returnVal) {
                super.onPostExecute(returnVal);

                if (!"error".equals(returnVal)) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.blockNo),
                            returnVal, Snackbar.LENGTH_LONG);
                    mySnackbar.show();
                }
            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    StructsArray contract = StructsArray.load(CommonConstants.STRUCTSARRAY_ADDRESS, web3, userWallet,
                            new DefaultGasProvider());
                    Tuple2<Utf8String, Uint256> t = contract.getEmployee(new Uint256(0)).send();

                    return "Employee Name:"+t.getValue1() +" Age : "+t.getValue2().getValue();
                } catch (Throwable e) {

                    e.printStackTrace();
                }
                return "error";

            }

        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
    }

}
