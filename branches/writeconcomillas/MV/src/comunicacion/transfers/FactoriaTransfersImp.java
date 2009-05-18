package comunicacion.transfers;
/**
 * Implementa los m�todos de la clase abstracta Factor�aTransfer
 *
 */
public class FactoriaTransfersImp extends FactoriaTransfers {
	/* (non-Javadoc)
	 * @see comunicacion.transfers.FactoriaTransfers#generarTransfer()
	 */
	public Transfer generarTransfer(){
			return new TransferImp();
	};
}
