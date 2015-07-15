package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;

import java.io.IOException;

public interface TlsAgreementCredentials extends TlsCredentials
{
	byte[] generateAgreement(AsymmetricKeyParameter serverPublicKey) throws IOException;
}
