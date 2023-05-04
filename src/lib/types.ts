export type IconsDesign = {
    name: string;
    background: string;
    icons: String[][];
    rotation: number;
    gap: number;
    padding: number;
    size: number;
}

export type Icon = {
    src: string;
    size?: number;
    color?: string;
    rotate?: number;
    flip?: boolean;
}