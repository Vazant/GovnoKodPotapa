public class Invoker {
    private Command castOneLine;
    private Command deleteExtSpaces;
    private Command deleteExtNewline;
    private Command deleteBeginningWhitespace;
    private Command deleteTheLastWhitespace;
    private Command deleteLogs;
    private Command deleteSLC;
    private Command deleteMLC;

    public Invoker(Command castOneLine, Command deleteExtSpaces,Command deleteExtNewline, Command deleteBeginningWhitespace, Command deleteTheLastWhitespace, Command deleteLogs, Command deleteSLC, Command deleteMLC) {
        this.castOneLine = castOneLine;
        this.deleteExtSpaces = deleteExtSpaces;
        this.deleteExtNewline = deleteExtNewline;
        this.deleteBeginningWhitespace = deleteBeginningWhitespace;
        this.deleteTheLastWhitespace = deleteTheLastWhitespace;
        this.deleteLogs = deleteLogs;
        this.deleteSLC = deleteSLC;
        this.deleteMLC = deleteMLC;
    }

    public void CastOneLine() {
        castOneLine.execute();
    }

    public void DeleteExtSpaces() {
        deleteExtSpaces.execute();
    }

    public void DeleteExtNewline() {
        deleteExtNewline.execute();
    }

    public void DeleteBeginningWhitespace() {
        deleteBeginningWhitespace.execute();
    }

    public void DeleteTheLastWhitespace() {
        deleteTheLastWhitespace.execute();
    }

    public void DeleteLogs() {
        deleteLogs.execute();
    }

    public void DeleteSLC() {
        deleteSLC.execute();
    }

    public void DeleteMLC() {
        deleteMLC.execute();
    }
}
