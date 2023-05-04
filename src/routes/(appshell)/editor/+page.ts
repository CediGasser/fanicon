export const load = async ({ fetch }) => {
    const icons = await fetch("/api/icons").then(res => res.json());
    return {
        icons
    };
};