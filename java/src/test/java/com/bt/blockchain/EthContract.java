package com.bt.blockchain;

import java.io.File;

import org.junit.Test;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.gas.DefaultGasProvider;

import com.bt.blockchain.contracts.StructsArray;

public class EthContract {

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
	public void addEmployee() throws Exception {
		initConnections();
		StructsArray contract = StructsArray.load(Constants.STRUCTSARRAY_ADDRESS, web3, credentials_wallet_1,
				new DefaultGasProvider());
		RemoteCall<TransactionReceipt> call = contract.addEmployee(new Utf8String("Max"), new Uint256(32));
		TransactionReceipt t = call.send();
		System.err.println(t);

	}

	@Test
	public void getEmployeeCount() throws Exception {
		initConnections();
		StructsArray contract = StructsArray.load(Constants.STRUCTSARRAY_ADDRESS, web3, credentials_wallet_1,
				new DefaultGasProvider());
		Uint256 t = contract.getEmployeeCount().send();
		System.err.println(t.getValue());

	}

	@Test
	public void getEmployeeByIndex() throws Exception {
		initConnections();
		StructsArray contract = StructsArray.load(Constants.STRUCTSARRAY_ADDRESS, web3, credentials_wallet_1,
				new DefaultGasProvider());
		Tuple2<Utf8String, Uint256> t = contract.getEmployee(new Uint256(1)).send();
		System.err.println(t.getValue1());
		System.err.println(t.getValue2().getValue());

	}
}
