import { json } from "@sveltejs/kit";

type IconGlob = {
    default: string
}


const getIcons = async () => {
    const icons = await import.meta.glob<IconGlob>("../../../icons/*.svg", { eager: true });
    return Object.entries(icons).map(([_, path]) => path.default);
}

export const GET = async ({ url }) => {
    const icons = await getIcons();
    let limit = 20;
    let offset = 0;

    if (url.searchParams.has("search")) {
        const search = url.searchParams.get("search") as string;
        return json(icons.filter(icon => icon.includes(search)));
    }

    if (url.searchParams.has("limit")) {
        limit = parseInt(url.searchParams.get("limit") as string);
    }

    if (url.searchParams.has("offset")) {
        offset = parseInt(url.searchParams.get("offset") as string);
    }

    return json(icons.slice(offset, offset + limit));
}