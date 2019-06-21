package com.bt.blockchain;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

public class EthMain {

	Web3j web3 = null;
	Credentials credentials_wallet_1 = null;

	public boolean initConnections() {
		if (web3 == null || credentials_wallet_1 == null) {
			try {
				web3 = Web3j.build(new HttpService(Constants.RPC_NODE));
				credentials_wallet_1 = WalletUtils.loadCredentials(Constants.WALLET_PASSWORD_1,
						new File(Constants.WALLET_1_KEYFILE_PATH));

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	@Test
	public void getBalance() throws IOException {
		initConnections();
		Request<?, EthGetBalance> balRequest = web3.ethGetBalance(credentials_wallet_1.getAddress(),
				DefaultBlockParameterName.LATEST);
		System.err.println(balRequest.send().getBalance());
	}

	@Test
	public void getBlockNumber() throws IOException {
		initConnections();
		EthBlockNumber blockNoRequest = web3.ethBlockNumber().send();
		System.err.println(Numeric.toBigInt(blockNoRequest.getResult()));

	}

	@Test
	public void getTransaction() throws IOException {
		initConnections();
		Request<?, EthGetTransactionReceipt> hashRequest = web3
				.ethGetTransactionReceipt("0xb6acbb4a2e0c7cc6a402f46847c2a97a49795c2166bdf0ca149c7156a6d7ab52");
		System.err.println(hashRequest.send().getResult());

	}

	@Test
	public void anotherTest() throws IOException {
		initConnections();
		EthGasPrice t = web3.ethGasPrice().send();
		System.err.println(t.getGasPrice());
	}

	
	/*@Test
	public void yetAnotherTest() throws IOException {
		initConnections();
		EthGasPrice t = web3.
		System.err.println(t.getGasPrice());
	}*/


	

}
