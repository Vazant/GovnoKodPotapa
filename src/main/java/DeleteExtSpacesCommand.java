public class DeleteExtSpacesCommand implements Command {
    private Plugins plugins;

    DeleteExtSpacesCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteExtSpaces(FileProcessing.text);
    }
}
