public class DeleteTheLastWhitespaceCommand implements Command {
    private Plugins plugins;

    DeleteTheLastWhitespaceCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteTheLastWhitespace(FileProcessing.text);
    }
}
