/* eslint-disable prettier/prettier */
import { NextFunction, Request, Response } from 'express';

export class ScrapperController {
    public getScrapping = async (req: Request, res: Response, next: NextFunction): Promise<void> => {
        try {
            const webUrl = req.params.webUrl;
            res.status(200).json({ data: [], message: webUrl });
        } catch (error) {
            next(error);
        }
    };
}
