import './Button.css';
import PropTypes from 'prop-types';
import React from 'react';

// Uso de forwardRef para poder usar el ref en el componente padre
// https://es.reactjs.org/docs/forwarding-refs.html
const Button = React.forwardRef(({text = "", icon = null, onClick}, ref) => {
    const ButtonIcon = icon;
    return (
        <button className='btn' onClick={onClick} ref={ref}> <ButtonIcon className='btn_icon'/> {text}</button>
    )
});

Button.propTypes = {
    text: PropTypes.string,
    icon: PropTypes.func,
    onClick: PropTypes.func,
}

export default Button;