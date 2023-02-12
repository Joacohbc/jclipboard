import { useState, useEffect } from "react";
import { ClipboardItem } from "./components/ClipboardItem";
import { Header } from './components/Header';
import { Overlay } from './components/Olverlay';
import axios from "axios";
import "./styles/App.css";
import { TestClipboardsData } from "./testData";

const emptyClipboard = {id:0, title:"", description:"", content:"", user:{id:0, username:"", email:"", createdAt:"", updatedAt:""}, expiration:"", createdAt:"", updatedAt:""};

function App() {

    // Donde se guardan TODOS los ClipboardItems que se obtienen de la peticion
    const [allClipboards, setAllClipboards] = useState(TestClipboardsData);

    // Donde se guardan los ClipboardItems que se estran motrando en pantalla
    const [clipboards, setClipboards] = useState(TestClipboardsData);

    // Determina si el Overlay esta visible y cual Clipboard esta mostrando
    const [visibleOverlay, setVisibleOverlay] = useState(false);
    const [currentClipboard, setCurrentClipboard] = useState(emptyClipboard);
    
    // Funcion para filtrar los casos que se estan mostrando
    const search = (text) => {

        // Si viene vacio re-cargo los ClipboardItems que traje de la peticion
        if(!text) {
            setClipboards(allClipboards);
            return;
        }

        setClipboards(allClipboards.filter((cp) => {
            return cp.title.toLowerCase().includes(text.toLowerCase()) 
            || cp.description.toLowerCase().includes(text.toLowerCase()) 
            || cp.content.toLowerCase().includes(text.toLowerCase());
        }));
    };

    useEffect(() => {
        // Peticion para traer todos los ClipboardItems desde el Servidor
        const getClipboards = async () => {
            const response = await axios.get("/clipboard/");
            setClipboards(response.data);
            setAllClipboards(response.data);
        };
        
        getClipboards().catch((error) => {
            console.log(error);
        });
    }, []);

    return (
        <>
        <Header filterContent={search}/>
        <Overlay clipboard={currentClipboard} visible={visibleOverlay} setVisible={setVisibleOverlay}/>
        <div className="container">
            {
                clipboards.map((clipboard) => {
                    return (
                        <ClipboardItem clipboard={clipboard} setClipboard={setCurrentClipboard} setVisibleOverlay={setVisibleOverlay} key={clipboard.id}/>
                    );
                })
            }
        </div>
        </>
    );
}

export default App;
