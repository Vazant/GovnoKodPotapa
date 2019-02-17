public class DeleteBeginningWhitespaceCommand implements Command {
    private Plugins plugins;
    FileProcessing fp = new FileProcessing();
    DeleteBeginningWhitespaceCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteBeginningWhitespace(fp.text);
    }
}
