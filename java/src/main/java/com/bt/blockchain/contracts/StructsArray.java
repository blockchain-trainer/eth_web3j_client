package com.bt.blockchain.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class StructsArray extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5061040f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063bca9a5c514610046578063c2a63e3b146100f4578063ffa4204b14610112575b600080fd5b6100726004803603602081101561005c57600080fd5b81019080803590602001909291905050506101d7565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b838110156100b857808201518184015260208101905061009d565b50505050905090810190601f1680156100e55780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b6100fc6102b9565b6040518082815260200191505060405180910390f35b6101d56004803603604081101561012857600080fd5b810190808035906020019064010000000081111561014557600080fd5b82018360208201111561015757600080fd5b8035906020019184600183028401116401000000008311171561017957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001909291905050506102c5565b005b606060008083815481106101e757fe5b90600052602060002090600202016000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561028c5780601f106102615761010080835404028352916020019161028c565b820191906000526020600020905b81548152906001019060200180831161026f57829003601f168201915b50505050509150600083815481106102a057fe5b9060005260206000209060020201600101549050915091565b60008080549050905090565b6000604051806040016040528084815260200183815250908060018154018082558091505090600182039060005260206000209060020201600090919290919091506000820151816000019080519060200190610323929190610335565b50602082015181600101555050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061037657805160ff19168380011785556103a4565b828001600101855582156103a4579182015b828111156103a3578251825591602001919060010190610388565b5b5090506103b191906103b5565b5090565b6103d791905b808211156103d35760008160009055506001016103bb565b5090565b9056fea265627a7a7230582077335bf8ddbe720b5b3d06ffa33900afa6d3e8c1605ef4775eaf94810bc6960764736f6c63430005090032\n";

    public static final String FUNC_GETEMPLOYEE = "getEmployee";

    public static final String FUNC_GETEMPLOYEECOUNT = "getEmployeeCount";

    public static final String FUNC_ADDEMPLOYEE = "addEmployee";

    @Deprecated
    protected StructsArray(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StructsArray(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StructsArray(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StructsArray(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple2<Utf8String, Uint256>> getEmployee(Uint256 index) {
        final Function function = new Function(FUNC_GETEMPLOYEE, 
                Arrays.<Type>asList(index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<Utf8String, Uint256>>(
                new Callable<Tuple2<Utf8String, Uint256>>() {
                    @Override
                    public Tuple2<Utf8String, Uint256> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Utf8String, Uint256>(
                                (Utf8String) results.get(0), 
                                (Uint256) results.get(1));
                    }
                });
    }

    public RemoteCall<Uint256> getEmployeeCount() {
        final Function function = new Function(FUNC_GETEMPLOYEECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> addEmployee(Utf8String name, Uint256 age) {
        final Function function = new Function(
                FUNC_ADDEMPLOYEE, 
                Arrays.<Type>asList(name, age), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static StructsArray load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StructsArray(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StructsArray load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StructsArray(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StructsArray load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StructsArray(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StructsArray load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StructsArray(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StructsArray> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StructsArray.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StructsArray> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StructsArray.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<StructsArray> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StructsArray.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StructsArray> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StructsArray.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
