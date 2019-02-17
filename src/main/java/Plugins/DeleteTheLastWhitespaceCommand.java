public class DeleteTheLastWhitespaceCommand implements Command {
    private Plugins plugins;
    FileProcessing fp = new FileProcessing();
    DeleteTheLastWhitespaceCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteTheLastWhitespace(fp.text);
    }
}
