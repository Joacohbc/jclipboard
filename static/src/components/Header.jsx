import { useEffect, useRef } from "react";
import Button from "../utils/Button";
import { BiPaperclip } from "react-icons/bi";
import { AiOutlineCloseCircle } from "react-icons/ai";
import "../styles/Header.css";

export function Header({ filterContent }) {
    const filter = useRef("");
    const cleanSearch = useRef("");

    const cleanFilter = () => {
        filter.current.value = "";
        filterContent("");
    };

    useEffect(() => {
        cleanSearch.current.style.display = "none";

        filter.current.addEventListener("keydown", (e) => {
            if (e.key == "Enter") {
                filterContent(e.target.value);
            }
        });

        filter.current.addEventListener("keyup", (e) => {
            if (e.key == "Escape") {
                filter.current.value = "";
                cleanSearch.current.style.display = "none";
                filterContent("");
            }
        });

        filter.current.addEventListener("input", (e) => {
            filterContent(e.target.value);
            cleanSearch.current.style.display =
                filter.current.value == "" ? "none" : "block";
        });

        // Mostrar el boton limpair cuando el input no esta vacio
    }, []);

    return (
        <div>
            <div className="header">
                <div className="header_logo">
                    <BiPaperclip size={"2em"} />
                    <h1>JClipboard</h1>
                </div>
                <div className="header_search">
                    <input className="header_search_input"  ref={filter} placeholder="Search..."></input>
                    <button className="header_search_close" ref={cleanSearch} onClick={cleanFilter}><AiOutlineCloseCircle/></button>
                </div>
            </div>
        </div>
    );
}