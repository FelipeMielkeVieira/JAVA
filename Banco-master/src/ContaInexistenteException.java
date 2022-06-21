public class ContaInexistenteException extends RuntimeException {
    public ContaInexistenteException() {
        super("Conta não encontrada!");
    }
}
