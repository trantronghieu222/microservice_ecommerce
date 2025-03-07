export const getDataTextStorage = (storeName: string): string | null => {
    if (localStorage.getItem(storeName)) {
        return localStorage.getItem(storeName);
    }
    return null;
}

export const getDataJsonStorage = (storeName: string): any | null => {
    if (localStorage.getItem(storeName)) {
        return JSON.parse(localStorage.getItem(storeName) as string);
    }
    return null;
}

export const setDataTextStorage = (storeName: string, data: string): void => {
    localStorage.setItem(storeName, data);
}

export const setDataJsonStorage = (storeName: string, data: any): void => {
    localStorage.setItem(storeName, JSON.stringify(data));
}

// Get Id
export const getIdFromToken = (token: string | null): number | null => {
    if (!token) return null;

    try {
        const payload = JSON.parse(atob(token.split(".")[1]));
        return payload.id ?? null;
    } catch (error) {
        console.error("Invalid token format:", error);
        return null;
    }
};

// Get Role
export const getRoleFromToken = (token: string | null): string[] => {
    if (!token) return [];

    try {
        const payload = JSON.parse(atob(token.split(".")[1]));
        return payload.roles ?? [];
    } catch (error) {
        console.error("Invalid token format:", error);
        return [];
    }
};
