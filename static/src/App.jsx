import { useState, useEffect } from "react";
import { ClipboardItem } from "./components/ClipboardItem";
import { Header } from './components/Header';
import { Overlay } from './components/Olverlay';
import axios from "axios";
import "./styles/App.css";

const emptyClipboard = {id:0, title:"", description:"", content:"", user:{id:0, username:"", email:"", createdAt:"", updatedAt:""}, expiration:"", createdAt:"", updatedAt:""};
const testClipboards = [
    {
        "id": 1,
        "title": "Hola Mundo en Java",
        "description": "Mensaje de Hola mundo escrito en Java",
        "content": `public class HolaMundo { 
    public static void main(String[] args) { 
        System.out.println("Hola Mundo!"); 
    } 
}`,
        "user": {
            "id": 1,
            "username": "joaco",
            "email": "Joaco@gmail.com",
            "createdAt": "2023-01-24 23:21",
            "updatedAt": "2023-01-24 23:21"
        },
        "expiration": "2023-01-31 13:00",
        "cretedAt": "2023-02-02 20:18",
        "updatedAt": "2023-02-02 20:18"
    },
    {
        "id": 2,
        "title": "Hola Mundo Go",
        "description": "Mensaje de Hola mundo escrito en Go",
        "content": `package main

import "fmt"

func main() {
    fmt.Println("Hello, World!")
}`,
        "user": {
            "id": 1,
            "username": "joaco",
            "email": "Joaco@gmail.com",
            "createdAt": "2023-01-24 23:21",
            "updatedAt": "2023-01-24 23:21"
        },
        "expiration": "2023-01-31 13:00",
        "cretedAt": "2023-02-02 20:18",
        "updatedAt": "2023-02-02 20:18"
    },
    {
        "id": 3,
        "title": "Hola Mundo en Python",
        "description": "Mensaje de Hola mundo escrito en Python",
        "content": "print(\"Hola Mundo!\")",
        "user": {
            "id": 1,
            "username": "joaco",
            "email": "Joaco@gmail.com",
            "createdAt": "2023-01-24 23:21",
            "updatedAt": "2023-01-24 23:21"
        },
        "expiration": "2023-01-31 13:00",
        "cretedAt": "2023-02-02 20:18",
        "updatedAt": "2023-02-02 20:18"
    },
    {
        "id": 4,
        "title": "Hola Mundo en C",
        "description": "Mensaje de Hola mundo escrito en C",
        "content": `#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!");
    return 0;
}`,
        "user": {
            "id": 1,
            "username": "joaco",
            "email": "Joaco@gmail.com",
            "createdAt": "2023-01-24 23:21",
            "updatedAt": "2023-01-24 23:21"
        },
        "expiration": "2023-01-31 13:00",
        "cretedAt": "2023-02-02 20:18",
        "updatedAt": "2023-02-02 20:18"
    }
];

function App() {

    // Donde se guardan TODOS los ClipboardItems que se obtienen de la peticion
    const [allClipboards, setAllClipboards] = useState(testClipboards);

    // Donde se guardan los ClipboardItems que se estran motrando en pantalla
    const [clipboards, setClipboards] = useState(testClipboards);

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
