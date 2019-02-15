public class DeleteBeginningWhitespaceCommand implements Command {
    private Plugins plugins;

    DeleteBeginningWhitespaceCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteBeginningWhitespace(FileProcessing.text);
    }
}
