import PropTypes from "prop-types";
import Button from "../utils/Button";
import { BiCopy } from "react-icons/bi";
import { MdOpenInNew } from "react-icons/md";
import "../styles/ClipboardItem.css";

export function ClipboardItem({ clipboard, setVisibleOverlay, setClipboard }) {
    const copy = () => {
        navigator.clipboard.writeText(clipboard.content);
    };

    return (
        <>
            <div className="clipboard-item">
                <div className="clipboard-item__title">{clipboard.title}</div>

                <div className="clipboard-item__expiration">
                    <b>Expiration Date</b> <br />
                    {clipboard.expiration}
                </div>

                <div className="clipboard-item__actions">
                    <Button
                        text={"Abrir"}
                        icon={MdOpenInNew}
                        onClick={() => {
                            // Cuando se de click que margque el estado del Overlay visible
                            // y a el mismo como Clipboard para el overlay
                            setVisibleOverlay(true);
                            setClipboard(clipboard);
                        }}
                    />
                    <Button text={"Copiar"} icon={BiCopy} onClick={copy} />
                </div>
            </div>
        </>
    );
}

ClipboardItem.propTypes = {
    clipboard: PropTypes.shape({
        id: PropTypes.number.isRequired,
        title: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
        content: PropTypes.string.isRequired,
        expiration: PropTypes.string.isRequired,
    }),
    setVisibleOverlay: PropTypes.func,
    setClipboard: PropTypes.func,
};
