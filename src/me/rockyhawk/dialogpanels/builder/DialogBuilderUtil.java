package me.rockyhawk.dialogpanels.builder;

public class DialogBuilderUtil {

//    public static DialogBase buildTeleportDialog() {
//        List<DialogBody> body = List.of(
//                DialogBody.plainMessage(Component.text("Select relative coordinates", NamedTextColor.GREEN), 100)
//        );
//
//        List<DialogInput> inputs = List.of(
//                DialogInput.create("x", DialogInputType.numberRange(100, Component.text("X Coordinate", NamedTextColor.YELLOW), "options.generic_value", -1000f, 1000f, 0f, 1f)),
//                DialogInput.create("y", DialogInputType.numberRange(100, Component.text("Y Coordinate", NamedTextColor.YELLOW), "%s: ~%s", -1000f, 1000f, 0f, 1f)),
//                DialogInput.create("z", DialogInputType.numberRange(100, Component.text("Z Coordinate", NamedTextColor.YELLOW), "%s: ~%s", -1000f, 1000f, 0f, 1f))
//        );
//
//        return DialogBase.create(
//                Component.text("Teleport somewhere COOL", NamedTextColor.YELLOW),
//                null,                // externalTitle (nullable)
//                true,                // canCloseWithEscape
//                false,               // pause
//                DialogBase.DialogAfterAction.CLOSE,
//                body,
//                inputs
//        );
//    }
//
//    public static DialogSpecialty buildTeleportDialogSpecialty() {
//        ActionButton cancel = ActionButton.create(Component.text("Cancel", NamedTextColor.RED), null, 50, null);
//        ActionButton teleport = ActionButton.create(Component.text("Teleport", NamedTextColor.GREEN), null, 50,
//                DialogAction.commandTemplate("tp ~$(x) ~$(y) ~$(z)"));
//        return DialogSpecialty.confirmation(teleport, cancel);
//    }
}