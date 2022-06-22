public class OperacaoZeroException extends RuntimeException {
    public OperacaoZeroException(String operacao) {
        super("Não é possível " + operacao + " zero reais.");
    }
}
