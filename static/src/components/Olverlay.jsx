import { useEffect, useRef } from 'react';
import { BiCopy } from 'react-icons/bi';
import { AiOutlineCloseCircle } from 'react-icons/ai';
import PropTypes from 'prop-types';
import Button from '../utils/Button';
import '../styles/Olverlay.css';

export function Overlay({clipboard, visible, setVisible}) {

    // Descargo el clipboard en variable
    const {title, description, content} = clipboard;

    // Obtengo la referencia del TextArea que muestar el contenido
    const txtAreaContent = useRef(null);
    
    const copy = () => {
        navigator.clipboard.writeText(txtAreaContent.current.value);
    };
    
    // Recargo el contenido del TextArea
    const reset = () => {
        txtAreaContent.current.value = content;
    };

    useEffect(() => {
        // Le marco el focus predeterminadamente
        txtAreaContent.current.focus();

        // Cuando se precione Escape que se salga del Visible 
        txtAreaContent.current.addEventListener('keydown', (e) => { if(e.key == 'Escape') setVisible(false) });

        // Esto para que siempre que pierda le Focus lo vuelva a tener 
        // (para evitar que el focus se vaya para los botones de atras o a los otros componentes)
        txtAreaContent.current.addEventListener('blur', (e) => txtAreaContent.current.focus());
        txtAreaContent.current.addEventListener('click', (e) => e.stopPropagation());

        // Recargo el contenido 
        txtAreaContent.current.value = content;
    }, [visible]);

    return (
        <div className={visible ? 'overlay_visible' : 'overlay_hidden'}>
            <AiOutlineCloseCircle className='close_button' onClick={() => setVisible(false)}/>
            <div className='overlay-content'>
                <h1 className='title'>{title}</h1>
                <p className='description'>{description}</p>
                <textarea className='content' defaultValue={content} ref={txtAreaContent}></textarea>
                <div className='overlay_buttons'>
                    <Button onClick={copy} icon={BiCopy} text={"Copiar al portapapeles"}/>
                    <Button onClick={reset} icon={AiOutlineCloseCircle} text={"Reiniciar contenido"}/>
                </div>
            </div>
        </div>
    );
}

Overlay.propTypes = {
    clipboard: PropTypes.shape({
        id: PropTypes.number.isRequired,
        title: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
        content: PropTypes.string.isRequired,
        expiration: PropTypes.string.isRequired,
    }),
    visible: PropTypes.bool,
    setVisible: PropTypes.func,
}