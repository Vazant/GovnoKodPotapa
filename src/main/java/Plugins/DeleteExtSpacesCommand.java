public class DeleteExtSpacesCommand implements Command {
    private Plugins plugins;
    FileProcessing fp = new FileProcessing();
    DeleteExtSpacesCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteExtSpaces(fp.text);
    }
}
